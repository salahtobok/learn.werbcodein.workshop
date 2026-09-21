import { Component, Signal, computed, inject } from '@angular/core';
import { toSignal } from '@angular/core/rxjs-interop';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

interface Task {
  id: number;
  title: string;
  completed: boolean;
}

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: 
    <div class="task-container">
      <h2>Angular 22 Signals + Spring Boot 4 WebFlux</h2>
      
      <div class="stats">
        <p>Total Tasks: {{ totalTasks() }}</p>
        <p>Completed: {{ completedTasks() }}</p>
      </div>

      <div class="task-input">
        <input [(ngModel)]="newTaskTitle" placeholder="New task..." (keyup.enter)="addTask()">
        <button (click)="addTask()">Add</button>
      </div>

      <ul class="task-list">
        <li *ngFor="let task of tasks()">
          <input type="checkbox" [checked]="task.completed" (change)="toggleTask(task)">
          <span [class.done]="task.completed">{{ task.title }}</span>
          <button class="delete-btn" (click)="deleteTask(task.id)">X</button>
        </li>
      </ul>
    </div>
  
})
export class TaskListComponent {
  private http = inject(HttpClient);
  
  // State Signals
  tasks = toSignal(this.http.get<Task[]>('http://localhost:8080/api/tasks'), { initialValue: [] });
  newTaskTitle = '';

  // Computed Signals
  totalTasks = computed(() => this.tasks().length);
  completedTasks = computed(() => this.tasks().filter(t => t.completed).length);

  addTask() {
    if (!this.newTaskTitle.trim()) return;
    this.http.post<Task>('http://localhost:8080/api/tasks', { title: this.newTaskTitle, completed: false })
      .subscribe(() => {
        this.newTaskTitle = '';
        this.refreshTasks();
      });
  }

  toggleTask(task: Task) {
    this.http.patch(http://localhost:8080/api/tasks//toggle, {}).subscribe(() => this.refreshTasks());
  }

  deleteTask(id: number) {
    this.http.delete(http://localhost:8080/api/tasks/).subscribe(() => this.refreshTasks());
  }

  private refreshTasks() {
    // In a real app with advanced Signals, we'd update the local writable signal.
    // Here we'll just reload the page for brevity in the workshop snippet.
    window.location.reload();
  }
}
