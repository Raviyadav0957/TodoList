import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Todo } from 'src/app/list-todos/list-todos.component';
// import { API_URL } from 'src/app/app.constants';
import { API_URL } from 'src/app/app.constants';
import { AUTHENTICATED_USER } from '../basic-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class TodoDataService {

  constructor(private http: HttpClient) { }

  retrieveAllTodos() {
    let userId = sessionStorage.getItem(AUTHENTICATED_USER);
    let headers = new HttpHeaders({
      userId
    });
    return this.http.get<Todo[]>(`${API_URL}/getAllTodos`, {headers});
  }

  retrieveTodo(todoId: number) {
    let userId = sessionStorage.getItem(AUTHENTICATED_USER);
    let headers = new HttpHeaders({
      userId
    });
    return this.http.get<Todo>(`${API_URL}/getTodo?todoId=${todoId}`, {headers});
  }

  deleteTodo(todoId: number) {
    let userId = sessionStorage.getItem(AUTHENTICATED_USER);
    let headers = new HttpHeaders({
      userId
    });
    return this.http.delete<Todo>(`${API_URL}/deleteTodo?todoId=${todoId}`, {headers});
  }

  createTodo(todo: Todo) {
    return this.http.post(`${API_URL}/createTodo`, todo);
  }

}
