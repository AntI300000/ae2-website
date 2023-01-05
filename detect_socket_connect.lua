local URL = ""
local PORT = 65535

local net = require("internet")
local con = net.open(URL, PORT)
if (con) then
  local data
  while (true) do
    data = con:read()
    if (data) then
      print(data)
    end
  end
else
  print("Connection failed to establish.")
end
