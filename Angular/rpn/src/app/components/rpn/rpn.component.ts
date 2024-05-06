import { Component } from '@angular/core';
import { Rpnservice } from '../../services/rpn.service';
import { FormControl, FormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-rpn-component',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './rpn.component.html',
  styleUrl: './rpn.component.scss'
})
export class RpnComponent {

  constructor(private rpnService: Rpnservice) { }

  expressionToTransform = new FormControl('', [Validators.required]);
  transformedExpression = '';
  error = '';

  onSubmit() {
    const expression = this.expressionToTransform.value;
  
    if (expression) {
      this.rpnService.transformToRPN(expression).subscribe({
        next: (response) => {
          // si la réponse est ok, on affiche le résultat
          this.transformedExpression = response;
          this.error = ''; // reset de error
        },
        error: (error) => {
          // si une erreur est survenue, on affiche le message d'erreur
          this.error = error.message;
          this.transformedExpression = '';
        }
      });
    } else {
      // si l'expression est vide, on affiche un message d'erreur de champ vide
      this.error = 'Veuillez entrer une opération à transformer en format RPN';
    }
  }
}
