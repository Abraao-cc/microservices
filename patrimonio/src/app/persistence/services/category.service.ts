import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first, Observable } from 'rxjs';
import { Category } from '../../persistence/model/category';


@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private apiUrl!: string;

  private cache: Category[] = [];

  constructor(private http: HttpClient) {
    this.apiUrl = 'http://localhost:8080/ativo-api/categorys';
  }

  findAll(): Observable<Category[]> {
    return this.http.get<Category[]>(this.apiUrl).pipe(first());
  }



  save(data: Category): Observable<Category> {
    return this.http.post<Category>(this.apiUrl + "/add", data);
  }

  updateData(id: string, data: Category): Observable<Category> {
    return this.http.put<Category>(`${this.apiUrl}/edit`, data);
  }

  deleteData(id: string): Observable<Category> {
    return this.http.delete<Category>(`${this.apiUrl}/delete/${id}`);
  }


}

