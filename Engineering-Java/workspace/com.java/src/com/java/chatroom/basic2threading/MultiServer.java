package com.java.chatroom.basic2threading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer { 
	public static void main(String [] args) throws IOException{ 
		ServerSocket serverSocket = new ServerSocket(9999); 
		
		while(true){ 
			System.out.println("等待客户端连接!"); 
			Socket server = serverSocket.accept(); 
			BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream())); 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(server.getOutputStream())); 
			
			while(true){ 
				String msg = br.readLine(); 
				System.out.println(msg); 
				
				bw.write("服务器-->" + msg); 
				bw.newLine(); 
				bw.flush(); 
			} 
		}
	} 
} 

