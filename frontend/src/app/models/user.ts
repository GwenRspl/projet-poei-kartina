export class User {
  id: number;
  civilite: string;
  prenom: string;
  nom: string;
  email: string;
  telephone: string;
  password: string;
  adresse: Adresse;
  role: Role;
  enteteCommande: EnteteCommande[];
  artiste: Artiste;
}
