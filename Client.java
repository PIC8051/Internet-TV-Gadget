package client;
import java.util.*;
import java.net.*;
import java.io.*;


public class Client extends Thread 
{
	static Socket s;
	DataInputStream dis;
	public Client()
	{
		try
		{
			System.out.println("Client is ready\n");
			s=new Socket("192.168.0.113",8000);
			dis=new DataInputStream(s.getInputStream());
		}
		catch(Exception ie)
		{
			System.out.println(ie);
			start();	
		}
	}
		public void run()
		{
			while(true)
			{
				try
				{
					System.out.println("Server: "+dis.readUTF());
					sleep(250);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		public static void main(String args[])
		{
			new Client();
			try
			{
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				DataOutputStream d = new DataOutputStream(s.getOutputStream());
				while(true)
				{
					String msg = br.readLine();
					d.writeUTF(msg);
				}
				
			}
			catch (Exception e)
			{
				System.out.print("No No");
		}

	}
	

}
