import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TodoDataService } from '../service/data/todo-data.service';
import { Todo } from '../list-todos/list-todos.component';
import { AUTHENTICATED_USER } from '../service/basic-authentication.service';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  constructor(private route: ActivatedRoute, private todoService: TodoDataService, private router: Router) { }
  todoId: number;
  todo: Todo;

  ngOnInit() {
    this.todoId = this.route.snapshot.params['todoId'];
    let userId = sessionStorage.getItem(AUTHENTICATED_USER);
    if(this.todoId != -1){
      this.todoService.retrieveTodo(this.todoId).subscribe(todoResp => {
        console.log('--todoResp--', todoResp);
        this.todo = todoResp;
      });
    } else {
      this.todo = new Todo(userId, '', new Date(), false);
    }
  }

  saveTodo() {
    // if(this.todoId == -1){
      this.todoService.createTodo(this.todo).subscribe(newTodo => {
        console.log('--newTodo--', newTodo);
        this.router.navigate(['todos']);
      });
    // } else {
    //   this.todoService.createTodo(this.todo).subscribe(updateTodo => {
    //     console.log('--updateTodo--', updateTodo);
    //     this.router.navigate(['todos']);
    //   });
    // }
  }

}
