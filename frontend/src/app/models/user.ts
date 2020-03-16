import { Address } from './address';
import { Role } from './role';
import { EnteteCommande } from './entete-commande';
import { Artiste } from './artiste';

export class User {
  id: number;
  civilite: string;
  prenom: string;
  nom: string;
  email: string;
  telephone: string;
  password: string;
  adresse: Address;
  role: Role;
  enteteCommande: EnteteCommande[];
  artiste: Artiste;
}
