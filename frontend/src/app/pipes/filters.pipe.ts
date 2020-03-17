import { Pipe, PipeTransform } from '@angular/core';
import { Photo } from '../models/photo';

@Pipe({
  name: 'filters'
})
export class FiltersPipe implements PipeTransform {

  transform(items: Photo[], format: number, orientation: number, prixMin: number, prixMax: number): any[] {
    // if (!items) {
    //   return [];
    // }
    // if (!format && !orientation && !prixMin && !prixMax) {
    //   return items;
    // }

    // let array: Photo[] = this.filterByMealTime(this.filterByMealType(items, mealtype), mealtime);

    // return array.filter(it => {
    //   return it.name.toLowerCase().includes(searchText);
    // });
    return items;
  }

  // filterByMealType(items: Photo[], mealtype: string): Photo[] {
  //   if (mealtype === 'all') {
  //     return items;
  //   }
  //   let array: Photo[] = [];
  //   items.map(it => {
  //     it.mealtypes.map(type => {
  //       if (type.label === mealtype) {
  //         array.push(it);
  //       }
  //     });
  //   });
  //   return array;
  // }

  // filterByMealTime(items: Photo[], mealtime: string): Photo[] {
  //   if (mealtime === 'all') {
  //     return items;
  //   }
  //   let array: Photo[] = [];
  //   items.map(it => {
  //     it.mealtypes.map(type => {
  //       type.mealTimes.map(time => {
  //         if (time.label === mealtime) {
  //           array.push(it);
  //         }
  //       });
  //     });
  //   });
  //   return array;
  // }

}
