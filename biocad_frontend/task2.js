let data = [{"name": "Mikky", "type": "dog", "age": 3}, {"name": "Neon", "type": "cat", "age": 0.5}];

const addButton = document.getElementById('addButton');
const changeButton = document.getElementById('changeButton');
const deleteButton = document.getElementById('deleteButton');

let table = document.createElement('table');
let tableHead = document.createElement('thead');
let tableBody = document.createElement('tbody');

table.appendChild(tableHead);
table.appendChild(tableBody);

document.getElementById('body').appendChild(table);

let headRow = document.createElement('tr');
let headingName = document.createElement('th');
headingName.innerHTML = "Name";
let headingType = document.createElement('th');
headingType.innerHTML = "Type";
let headingAge = document.createElement('th');
headingAge.innerHTML = "Age";

headRow.appendChild(headingName);
headRow.appendChild(headingType);
headRow.appendChild(headingAge);
tableHead.appendChild(headRow);


function deleteTable() {
    while (tableBody.firstChild) {
        tableBody.removeChild(tableBody.firstChild);
    }
}


function addRow() {
    let newRow = prompt('Введите строку в формате name,type,age', 'Eugeny,human,20').split(',');
    data.push({name: newRow[0], type: newRow[1], age: newRow[2]})
    rerenderTable(data);
}


function changeRow() {
    let row = prompt('Введите номер строки для изменения:', 1);
    let rowData = data[row - 1]
    let rowNewData = prompt('Введите изменения в формате name,type,age', `${rowData.name},${rowData.type},${rowData.age}`).split(',');
    data[row - 1] = {name: rowNewData[0], type: rowNewData[1], age: rowNewData[2]};
    rerenderTable(data);
}


function deleteRow() {
    let row = prompt('Введите номер строки для удаления:', 1);
    data.splice(row - 1, 1);
    rerenderTable(data);
}


function rerenderTable(arrData) {
    deleteTable()
    arrData.forEach((rowData, index) => {
        let row = document.createElement('tr');
        row.id = `row-${index}`;
        let rowName = document.createElement('td');
        rowName.innerHTML = rowData.name;
        let rowType = document.createElement('td');
        rowType.innerHTML = rowData.type;
        let rowAge = document.createElement('td');
        rowAge.innerHTML = String(rowData.age);

        row.appendChild(rowName);
        row.appendChild(rowType);
        row.appendChild(rowAge);

        tableBody.appendChild(row);
    })
}

rerenderTable(data)

addButton.addEventListener('click', addRow);
changeButton.addEventListener('click', changeRow);
deleteButton.addEventListener('click', deleteRow);