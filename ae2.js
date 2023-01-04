var tableCurrent = 0;
function createStorageScreen(tableLength) {
//todo: learn to import the table instead of the number given
	var container = document.getElementById("storageBox");
	for(let i = tableCurrent; i < tableLength; i++) {
		container.insertAdjacentHTML("beforeend","<div> amorgus "+tableCurrent+"</div>");
		tableCurrent++;
	}
	//document.getElementById("summonButton").setAttributeNode(hidden);
}