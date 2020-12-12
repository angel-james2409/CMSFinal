import { Component, OnInit } from '@angular/core';
import { acceptreject } from './acceptreject';
import { AcceptrejectService } from './acceptreject.service';

@Component({
  selector: 'app-acceptreject',
  templateUrl: './acceptreject.component.html',
  styleUrls: ['./acceptreject.component.css']
})
export class AcceptrejectComponent implements OnInit {
result:acceptreject[];
  constructor(private acreService:AcceptrejectService) { }

  ngOnInit(): void {
    this.acreService.showOrderFun().subscribe((data)=>{this.result=data});
  }

}
