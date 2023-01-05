local net = require("internet")

local con = net.open("irc.esper.net",6667) --define server / port here, this will connect to the server
local msg = ""
while(true) do
msg = con:read()
print(msg)