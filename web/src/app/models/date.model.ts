export class DateModel {
  year: number;
  month: number;
  day: number;

  public constructor(date: string | any) {
    if (typeof date === 'string') {
      const obj = date.split('-');
      this.year = parseInt(obj[0], 10);
      this.month = parseInt(obj[1], 10);
      this.year = parseInt(obj[2], 10);
    }
  }

  public toString(): string {
    if (typeof this === 'string') {
      return this;
    }
    return this.year + '-' + this.month + '-' + this.day;
  }
}
