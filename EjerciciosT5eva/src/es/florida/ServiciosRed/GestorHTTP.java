package es.florida.ServiciosRed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class GestorHTTP implements HttpHandler {

	int tempActual = 20;
	int tempTermostato = 20;

	@Override
	/*
	 * Metode: handle 
	 * Descripcio: Gestiona les peticions http 
	 * Parametres d'entrada:httpExchange
	 *  Parametres d'exida: no
	 */
	public void handle(HttpExchange httpExchange) throws IOException {
		String requestParamValue = null;

		if ("GET".equals(httpExchange.getRequestMethod())) {
			requestParamValue = handleGetRequest(httpExchange);
			handleGETResponse(httpExchange, requestParamValue);

		} else if ("POST".equals(httpExchange.getRequestMethod())) {
			requestParamValue = handlePostRequest(httpExchange);
			try {
				handlePOSTResponse(httpExchange, requestParamValue);
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/*
	 * Metode: handlePOSTResponse 
	 * Descripcio: creem handlePOSTResponse 
	 * Parametres d'entrada: httpExchange , requestParamValue 
	 * Parametres d'exida:
	 */
	private void handlePOSTResponse(HttpExchange httpExchange, String requestParamValue)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		OutputStream outputStream = httpExchange.getResponseBody();
		String htmlResponse = requestParamValue;
		String[] url = htmlResponse.split("=");
		String[] correo = htmlResponse.split(":");
//			System.out.println(correo[0]);

		if (url[0].equals("setTemperatura")) {
			httpExchange.sendResponseHeaders(200, htmlResponse.length());
			outputStream.write(htmlResponse.getBytes());
			outputStream.flush();
			outputStream.close();
			tempTermostato = Integer.parseInt(url[1]);
			System.out.println("Se ha cambiado la temperatura del termostato a: " + tempTermostato);
			regularTemperatura();

		}
		if (correo[0].equals("notificarAveria")) {
			String[] datosCorreo = correo[1].split(";");
//			System.out.println(datosCorreo[0]);
			String email_remitente = datosCorreo[0].split("=")[1];
			String pass_remitente = datosCorreo[1].split("=")[1];
//			System.out.println(email_remitente);
//			System.out.println(pass_remitente);
			String mensaje = "Averia";
			String imagen = "foto.jpg";
			String pdf = "AE5_T5_ServiciosRed.pdf";
			String[] emailDestino = { "mantenimientoinvernalia@gmail.com", "megustaelfresquito@gmail.com" };
			String[] anexo = { imagen, pdf };
			try {
				envioMail(mensaje, email_remitente, pass_remitente, emailDestino, anexo);
			} catch (UnsupportedEncodingException e) {

				e.printStackTrace();
			} catch (MessagingException e) {

				e.printStackTrace();
			}

			htmlResponse = "Informacion de Correo Recibida";
			httpExchange.sendResponseHeaders(200, htmlResponse.length());
			outputStream.write(htmlResponse.getBytes());
			outputStream.flush();
			outputStream.close();
		}

	}

	/*
	 * Metode: handlePostRequest 
	 * Descripcio: LLig el body del post 
	 * Parametres d'entrada: httpExchange 
	 * Parametres d'exida: return grados, les linees que s'escriuen en postman
	 */

	private String handlePostRequest(HttpExchange httpExchange) throws IOException {
		// TODO Auto-generated method stub
		InputStream inputStream = httpExchange.getRequestBody();
		InputStreamReader isr = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(isr);
		String grados = "";

		String linea = br.readLine();
		while (linea != null) {
			grados += linea;
			linea = br.readLine();
		}
		br.close();

		return grados;
	}

	/*
	 * Metode: regularTemperatura 
	 * Descripcio: Depenent la temperatura que fique en la variable tempTermostato la temperatura actual apuja o abaixa cada 5 segons
	 * Parametres d'entrada: 
	 * Parametres d'exida: la temperatua actual actualiza
	 */

	private void regularTemperatura() throws InterruptedException {
		while (tempActual != tempTermostato) {
			if (tempActual <= tempTermostato) {
				tempActual++;
			} else {
				tempActual--;
			}
			Thread.sleep(5000);
		}
	}

	/*
	 * Metode: handleGETResponse 
	 * Descripcio: Gestio del get
	   Parametres d'entrada: httpExchange ,requestParamValue 
	 * Parametres d'exida:
	 */

	private void handleGETResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {
		// TODO Auto-generated method stub
		OutputStream outputStream = httpExchange.getResponseBody();

		if (requestParamValue.equals("temperaturaActual")) {

			String htmlResponse = "<html><body><p> La temperatura actual es :" + tempActual
					+ " ºC </p><p>Temperatura termostato: " + tempTermostato + " ºC </p></body></html>";
			httpExchange.sendResponseHeaders(200, htmlResponse.length());
			outputStream.write(htmlResponse.getBytes());
			outputStream.flush();
			outputStream.close();

		}

	}

	/*
	 * Metode: handleGetRequest 
	 * Descripcio: Agarra la url y la dividix 
	 * Parametres d'entrada: HttpExchange httpExchange 
	 * Parametres d'exida: la url dividida per el parametre del split que es un "?"
	 */

	private String handleGetRequest(HttpExchange httpExchange) {
		// TODO Auto-generated method stub
		return httpExchange.getRequestURI().toString().split("\\?")[1];
	}

	/*
	 * Metode: envioMail 
	 * Descripcio: Metode que envia el email al tecnico 
	 * Parametres d'entrada: mensaje, email_remitente, email_remitente_pass, anexo 
	 * Parametres d'exida:
	 */

	public static void envioMail(String mensaje, String email_remitente, String email_remitente_pass,
			String[] email_destino, String[] anexo) throws UnsupportedEncodingException, MessagingException {
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.user", email_remitente);
		props.put("mail.smtp.clave", email_remitente_pass);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(email_remitente));
		message.addRecipients(Message.RecipientType.TO, email_destino[0]);
		message.addRecipients(Message.RecipientType.TO, email_destino[1]);
		message.setSubject("AVERIA");
		BodyPart messageBodyPart1 = new MimeBodyPart();
		messageBodyPart1.setText(mensaje);
		BodyPart messageBodyPart2 = new MimeBodyPart();
		DataSource src = new FileDataSource(anexo[0]);
		messageBodyPart2.setDataHandler(new DataHandler(src));
		messageBodyPart2.setFileName(anexo[0]);
		BodyPart messageBodyPart3 = new MimeBodyPart();
		DataSource src2 = new FileDataSource(anexo[1]);
		messageBodyPart3.setDataHandler(new DataHandler(src2));
		messageBodyPart3.setFileName(anexo[1]);
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart1);
		multipart.addBodyPart(messageBodyPart2);
		multipart.addBodyPart(messageBodyPart3);
		message.setContent(multipart);
		Transport transport = session.getTransport("smtp");
		transport.connect("smtp.gmail.com", email_remitente, email_remitente_pass);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
}
