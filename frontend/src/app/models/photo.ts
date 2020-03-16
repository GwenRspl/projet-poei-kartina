export class Photo {
  id: number;
  title: string;
  prix: number;
  tirages: number;
  date_debut: string;
  date_fin: string;
  imgUrl: string;
  imgThumbnail: string;
  theme: Theme[];
  orientation: Orientation;
  format: any[];
  artiste: Artiste;
  tag: Tag[];
}
