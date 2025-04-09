export class Task {
  id: number;
  title: string;
  description: string;
  status: string;
  createdAt: string;

  constructor(id: number, title: string, description: string, status: string, createdAt: string) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.status = status;
    this.createdAt = createdAt;
  }
}
