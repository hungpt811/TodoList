var todoListApi = 'http://localhost:8080/todo/list';
var todoAddApi = 'http://localhost:8080/todo/add';
var todoDeleteApi = 'http://localhost:8080/todo/delete';
var todoDeleteAllApi = 'http://localhost:8080/todo/deleteAll';

var start = () => {
    getTodo(renderTodo);
    handleAdd();
}

start();

// other function

function getTodo(callback) {
    fetch(todoListApi)
        .then(function(res) {
            return res.json();
        })
        .then(callback)
}

function addTodos (data, callback){
    var options = {
        method: 'POST',
        headers:{
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }
    fetch(todoAddApi, options)
       .then(function(reponse){
            reponse.json();
       })
       .then(callback);
}

function renderTodo(todos) {
    var listTodos = document.querySelector('.todoList');
    var htmls = todos.map(function(todo){
        return `
        <li class="todo todo-item-${todo.id}"> ${todo.name}
            <span onclick="handleDelete(${todo.id})">
                <i class='bx bx-check'></i>
            </span> 
        </li>
        `
    });
    listTodos.innerHTML = htmls.join('');
  

}

function handleAdd() {
    var addBtn = document.querySelector('#add');
    addBtn.onclick = function() {
        var name = document.querySelector('input[name="name"]').value;
        var formData = {
            name: name
        }

        addTodos(formData, function() {
            getTodo(renderTodo);
            ClearInputField()
        });
    }
}

function handleDelete(id) {
    var options = {
        method: 'DELETE',
        headers:{
            'Content-Type': 'application/json'
        }       
    }
    fetch(todoDeleteApi + '/' + id, options)
       .then(function(reponse){
            reponse.json();
       })
       .then(function(){
            var todoItem = document.querySelector('.todo-item-'+id);
            if(todoItem){
                todoItem.remove();
            }
       });
}
function handleDeleteAll() {
    var options = {
        method: 'DELETE',
        headers:{
            'Content-Type': 'application/json'
        }       
    }
    fetch(todoDeleteAllApi, options)
       .then(function(reponse){
            reponse.json();
       })
       .then(function(){    
            var listTodo= document.querySelector(".todoList");
            listTodo.innerHTML = "";      
       });      
}

function ClearInputField() { 
    var input = document.querySelector('input[name="name"]');
    input.value = "";
   
}
