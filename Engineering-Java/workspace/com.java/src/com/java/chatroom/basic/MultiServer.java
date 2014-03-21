package com.java.chatroom.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
	public static void main(String [] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("等待连接!");
		Socket server = serverSocket.accept();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));
		while(true){
			System.out.println("一个客户端建立连接!");
			
			String msg = "欢迎！";
			
			bw.write(msg); 
			bw.newLine(); 
			bw.flush(); 
		}
	} 
} 
