import { LigneCommande } from './ligne-commande';

export class EnteteCommande {
  id: number;
  statut: Statut;
  prixTotal: number;
  date: string;
  ligneCommandes: LigneCommande[];
}
