import {Component, OnInit} from '@angular/core';
import {PassagesService} from "./passages.service";
import {Passage} from "./passage";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'k8s-ocp-view';

  passages: Passage[] = [];
  form: FormGroup;

  constructor(private passagesService: PassagesService,
              private fb: FormBuilder) {
    this.form = fb.group({
      plate: fb.control(null, Validators.required),
      speed: fb.control(null, [Validators.required, Validators.min(1)])
    });
  }

  ngOnInit() {
    this.loadPassages();
  }

  loadPassages() {
    this.passagesService.findAll()
      .subscribe(passages => this.passages = passages);
  }

  save() {
    if (this.form.invalid) {
      return;
    }

    const form = this.form.getRawValue();

    const passage = {plate: form.plate, speed: form.speed};

    this.passagesService.save(passage)
      .subscribe(passage => {
        this.passages.push(passage);
        this.form.reset();
      });
  }
}
