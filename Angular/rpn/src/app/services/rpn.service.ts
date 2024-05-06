import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Rpnservice {

  constructor(private http: HttpClient) { }

  serviceUrl = "http://localhost:8080/api/rpn/tranform-to-rpn"

  transformToRPN(expressionToTransform: string): Observable<any> {
    //appel du service backend
    return this.http.post<string>(this.serviceUrl, { expression: expressionToTransform })
      .pipe(
        catchError((error: HttpErrorResponse) => {
          let errorMessage = 'Une erreur inconnue est survenue';
          if (error.error instanceof ErrorEvent) {
            // Erreur côté client ou réseau.
            errorMessage = `Erreur: ${error.error.message}`;
          } else {
            // Erreur côté serveur.
            if (error.error.text) {
              errorMessage = error.error.text;
            }
          }
          return throwError(() => new Error(errorMessage)) ;
        })
      );
  }

}
