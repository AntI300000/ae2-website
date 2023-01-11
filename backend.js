const net = require("net");

var server = net.createServer();
var socket = new net.Socket({allowHalfOpen: true}); 
var port = "65535";
var host = "localhost"
//var host = "127.0.0.1";

//socket.connect({port: port, host: host}, function() {
    // whatever you need the socket listener function to do
//});

server.listen(port, host, () => { 
console.log(`TCP server listening on ${host}:${port}`); 
}); 

server.on('connection',  (socket) => { 
var clientAddress = `${socket.remoteAddress}:${socket.remotePort}`; 
console.log(`new client connected: ${clientAddress}`); 
 }); 