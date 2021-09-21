/**
 * Cliente
 * 1. Criar socket
 * 2. Conectar com o servidor
 * 3. Enviar/receber mensagens
 * 4. Fechar conexão
 */



// Client side C/C++ program to demonstrate Socket programming
#include <stdio.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <string.h>

#define PORT 80
#define BUFFER_SIZE 1024
//#define IP_SERVER "10.0.98.1"


int main(int argc, char const *argv[]) {

    int sock = 0, valread;
    struct sockaddr_in serv_addr;
    char *hello = "Mensagem do CLIENTE";
    char buffer[BUFFER_SIZE] = {0};

    // 1. Criar socket
    if ((sock = socket(AF_INET, SOCK_STREAM, 0)) < 0)
    {
        printf("\n Socket creation error \n");
        return -1;
    }
   
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(PORT);
       
    if(inet_pton(AF_INET, argv[1], &serv_addr.sin_addr)<=0) 
//    if(inet_pton(AF_INET, IP_SERVER, &serv_addr.sin_addr)<=0) 
    {
        printf("\nInvalid address/ Address not supported \n");
        return -1;
    }
    
    // 2. Conectar com o servidor
    if (connect(sock, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0)
    {
        printf("\nConnection Failed \n");
        return -1;
    }

    // 3. Enviar e receber mensagens
// Servidor pede o nome
    valread = read(sock, buffer, 1024);
    printf("Echo: %s", buffer);
// Cliente envia o nome
    char nome[100];
    scanf("%s", nome);
    send(sock , nome , strlen(nome) , 0 );

// Servidor pede a idade
    valread = read(sock, buffer, 1024);
    printf("Echo: %s", buffer);
// Cliente envia a idade
    char idade[5];
    scanf("%s", idade);
    send(sock , idade , strlen(idade) , 0 );


// Servidor pede a altura
    valread = read(sock, buffer, 1024);
    printf("Echo: %s", buffer);
// Cliente envia a idade
    char altura[8];
    scanf("%s", altura);
    send(sock , altura , strlen(altura) , 0 );


/*
    send(sock , hello , strlen(hello) , 0 );
    printf("Client Message sent\n");
    valread = read( sock , buffer, 1024);
    printf("Mensagem recebida: %s\n",buffer );
*/

    // 4. Fechar conexão
    close(sock);
    return 0;
}