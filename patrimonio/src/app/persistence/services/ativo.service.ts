import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { first, Observable, of, tap } from 'rxjs';
import { Ativo } from '../../persistence/model/ativo';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class AtivoService {
  private apiUrl = 'http://localhost:8080/ativo-api/ativos';
  private cache: Ativo[] = [];


  constructor(
    private http: HttpClient,
    private _sbar: MatSnackBar
  ) { }

  getAtivos(): Observable<Ativo[]> {
    return this.http.get<Ativo[]>(`${this.apiUrl}`);
  }

 save(record: Ativo){
  if (record.id !==null) {
       return this.update(record);
     }
     return this.create(record);    
 }
  update(record: Ativo) {
    return this.http.put<Ativo>(`${this.apiUrl}/edit`,record).pipe(first());
  }

   create(record: Ativo) {
    return this.http.post<Ativo>(this.apiUrl+'/add', record).pipe(first());
  }
  private getById(id: string) {
    return this.http.get<Ativo>(`${this.apiUrl}/${id}`).pipe(first());
  }
  delete(id: string) {
    return this.http.delete<Ativo>(`${this.apiUrl}/${id}`).pipe(first());
  }

  mensagem(msg: string): void {
    this._sbar.open(msg, '', {
        horizontalPosition: 'end',
        verticalPosition: 'top',
        duration: 5000

    });
}

}
