# Java Socket Programming – Single & Multi-Threaded Server

This project demonstrates **Client-Server Communication** in Java using **Socket Programming**, featuring both **Single-Threaded** and **Multi-Threaded** server implementations.  
It helps visualize how multiple clients can connect and communicate with a server either sequentially or in parallel.

---

## Overview

### Single-Threaded Server
- Handles **one client at a time**.
- Waits for the current client to finish before accepting a new one.
- Simple structure — good for understanding basic server-client communication.

### Multi-Threaded Server
- Handles **multiple clients simultaneously** using Java **Threads**.
- Each client connection is processed in a **separate thread**.
- Demonstrates **parallelism** and concurrent handling of client requests.

### Multi-Client Simulation
- Creates **multiple client threads (e.g., 50)** that connect to the multi-threaded server concurrently.
- Useful for testing how well the server handles simultaneous connections.

---

## Project Structure

📦 JavaSocketProgramming
┣ 📂 SingleThreaded
┃ ┣ 📜 Server.java
┃ ┗ 📜 Client.java
┣ 📜 MultiServer.java
┗ 📜 MultiClient.java


---

## 🧠 Key Concepts Learned

- TCP/IP socket communication (`ServerSocket`, `Socket`)
- Data exchange using `InputStream`, `OutputStream`, `PrintWriter`, and `BufferedReader`
- Connection establishment and closing protocol
- Multithreading and concurrency in Java
- Handling multiple client connections simultaneously

---

## 🚀 How to Run

### 🖥️ Run the Single-Threaded Server
1. Start the server:
   ```bash
   javac SingleThreaded/Server.java
   java SingleThreaded.Server
