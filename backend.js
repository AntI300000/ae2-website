const net = require("net");

const server = new net.Server();
server.listen({ host: "127.0.0.1", port: 9999 });
server.on("connection", client => {
  client.write("Hello\n")
});
