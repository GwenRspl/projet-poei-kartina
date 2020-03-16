import { Tag } from './tag';
import { Cadre } from './cadre';
import { Orientation } from './orientation';
import { Photo } from './photo';

export class LigneCommande {
  id: number;
  photo: Photo;
  quantity: number;
  prixUnitaire: number;
  format: Orientation;
  finition: Tag;
  cadre: Cadre;
}
