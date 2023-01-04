local json = require("json")

local jsonStorage = {}

jsonStorage.saveTable = function(t, filename)
	local file = io.open(filename, "w")
	
	if file then
		local contents = json.encode(t)
		file:write(contents)
		file:close()
		return true
	else
		return false
	end
end

local items = getItemsInNetwork()

jsonStorage.saveTable(items, "cache.json")

-- send cache.json to web server
