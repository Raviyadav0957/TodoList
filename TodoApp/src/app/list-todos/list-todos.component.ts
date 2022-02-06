import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { Router } from '@angular/router';


export class Todo {
  constructor(
    public userId: string,
    public description: string,
    public targetDate: Date,
    public isCompleted: boolean
  ){}
}

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  constructor(private todoService: TodoDataService, private router: Router) { }
  todos: Todo[];
  message: string;

  ngOnInit() {
    this.fetchTodos();
  }

  addTodo() {
    this.router.navigate(['todos', -1]);
  }

  updateTodo(todoId: string) {
    this.router.navigate(['todos', todoId]);
  }

  deleteTodo(todoId: number): void {
    console.log('--id--', todoId);
    this.todoService.deleteTodo(todoId).subscribe(deleteResp => {
      console.log('--deleteResp--', deleteResp);
      this.message = `Todo deleted Successfully`;
      this.fetchTodos();
    });
  }

  fetchTodos() {
    this.todoService.retrieveAllTodos().subscribe(todosResp => {
      console.log('--todosResp--', todosResp);
      this.todos = todosResp;
    });
  }
  
}
