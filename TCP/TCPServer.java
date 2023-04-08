import java.io.*;
import java.net.*;
import java.util.ArrayList;

class TCPServer {
	public static void main(String argv[]) throws Exception

	{
		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket = new ServerSocket(6667);
		System.out.println(welcomeSocket.getLocalSocketAddress());
		System.out.println(welcomeSocket.getReuseAddress());

while (true) {
	

		Socket connectionSocket = welcomeSocket.accept();

		while (true) {
			try {
				if (!connectionSocket.isConnected()) {
					connectionSocket = welcomeSocket.accept();
				} else {
					System.out.println("Connected to client");
					BufferedReader inFromClient = new BufferedReader(
							new InputStreamReader(connectionSocket.getInputStream()));
							
					clientSentence = inFromClient.readLine();
					File outpt = new File(clientSentence+".txt");
					if (!outpt.exists()) {
						outpt.createNewFile();

					}
					else{
						outpt.delete();
						outpt.createNewFile();
					}
					if (clientSentence == null) {
						connectionSocket.close();
						break;
					}
					System.out.println("Received: " + clientSentence);
					clientSentence = inFromClient.readLine();
					BufferedWriter writer = new BufferedWriter(new FileWriter(outpt));
					String[] data = clientSentence.split(";");
					for (String string : data) {
						writer.write(string);

						writer.newLine();

					}
    
    				writer.close();
					capitalizedSentence = clientSentence.toUpperCase() + "\n";
					DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
					System.out.println("Sending: " + capitalizedSentence);
					outToClient.writeBytes(capitalizedSentence);
				}	
			} catch (Exception e) {
				// TODO: handle exception
			}
			

		}
	}
}}