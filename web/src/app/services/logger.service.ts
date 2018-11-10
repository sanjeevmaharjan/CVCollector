import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';

export abstract class Logger {

  info: any;
  warn: any;
  error: any;
}

@Injectable({
  providedIn: 'root'
})
export class LoggerService implements Logger{

  info: any;
  warn: any;
  error: any;

  constructor() { }

  log(msg: any) {
    console.log(msg);
  }
}
