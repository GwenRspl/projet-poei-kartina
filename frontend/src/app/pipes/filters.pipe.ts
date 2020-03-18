import { Pipe, PipeTransform } from '@angular/core';
import { Photo } from '../models/photo';
import { Format } from '../models/format';
import { Orientation } from '../models/orientation';

@Pipe({
  name: 'filters',
  pure: false
})
export class FiltersPipe implements PipeTransform {

  transform(items: Photo[], formats: number[], orientations: number[], priceRange: number[]): any[] {
    if (!items) {
      return [];
    }
    if (!formats && !orientations && !priceRange) {
      return items;
    }
    return this.translatePrices(priceRange, this.translateFormats(formats, this.translateOrientations(orientations, items)));
  }

  translateOrientations(orientations: number[], array: Photo[]): Photo[] {
    if (orientations !== []) {
      return array.filter(it => {
        return orientations.includes(it.orientation.id);
      });
    }
  }

  translateFormats(formats: number[], array: Photo[]): Photo[] {
    if (formats !== []) {
      return array.filter(it =>
        it.format.some(format => formats.includes(format.id)));
    }
  }

  translatePrices(prices: number[], array: Photo[]): Photo[] {
    let result: Photo[] = [];
    if (prices.includes(1)) {
      array.forEach(element => {
        if (element.prix < 50) {
          result.push(element);
        }
      });
    }
    if (prices.includes(2)) {
      array.forEach(element => {
        if (!result.includes(element)) {
          if (element.prix >= 50 && element.prix <= 100) {
            result.push(element);
          }
        }
      });
    }
    if (prices.includes(3)) {
      array.forEach(element => {
        if (!result.includes(element)) {
          if (element.prix >= 100 && element.prix <= 200) {
            result.push(element);
          }
        }
      });
    }
    if (prices.includes(4)) {
      array.forEach(element => {
        if (!result.includes(element)) {
          if (element.prix >= 200 && element.prix <= 500) {
            result.push(element);
          }
        }
      });
    }
    if (prices.includes(5)) {
      array.forEach(element => {
        if (!result.includes(element)) {
          if (element.prix >= 500 && element.prix <= 1000) {
            result.push(element);
          }
        }
      });
    }
    return result;
  }


}
