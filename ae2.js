var tableCurrent = 0;
function createStorageScreen(tableLength) {
//todo: learn to import the table instead of the number given
//also parse
	var container = document.getElementById("storageBox");
	for(let i = tableCurrent; i < tableLength; i++) {
		container.insertAdjacentHTML("beforeend","<div> amorgus "+tableCurrent+"</div>");
		tableCurrent++;
	}
	document.getElementById("summonButton").style.display="none";
}