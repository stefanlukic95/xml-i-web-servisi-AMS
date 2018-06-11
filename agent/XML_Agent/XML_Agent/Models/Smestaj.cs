using MongoDB.Bson.Serialization.Attributes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using MongoDB.Bson;

namespace XML_Agent.Models
{
    
    public class Smestaj
    {

        [BsonId]
        [BsonRepresentation(BsonType.ObjectId)]
        public string Id { get; set; }
        [BsonElement("naziv")]
        public string Naziv { get; set; }
        [BsonElement("kapacitet")]
        public int Kapacitet { get; set; }
        [BsonElement("naseljenoMesto")]
        public string NaseljenoMesto { get; set; }
        [BsonElement("opis")]
        public string Opis { get; set; }
        [BsonElement("slika")]
        public string Slika { get; set; }
        [BsonElement("rezervacije")]
        public List<Rezervacija> Rezervacije { get; set; }
        [BsonElement("zauzeto")]
        public List<Zauzetost> Zauzeto { get; set; }
        [BsonElement("komentar")]
        public List<Komentari> Komentari { get; set; }
        [BsonElement("agent")]
        public string Agent { get; set; }
        [BsonElement("tipSmestaja")]
        public string TipSmestaja { get; set; }
        [BsonElement("kategorijaSmestaja")]
        public string KategorijaSmestaja { get; set; }
        [BsonElement("termini")]
        public List<Termin> Termini { get; set; }
        [BsonElement("dodatneUsluge")]
        public List<DodatnaUsluga> DodatneUsluge { get; set; }

        public Smestaj(String naziv, int kapacitet, string naseljeno_mesto, string opis, String slika, List<Rezervacija> rezervacije, List<Zauzetost> zauzeto, List<Komentari> komentari, string agent, string tipSmestaja, string kategorijaSmestaja, List<Termin> termini, List<DodatnaUsluga> dodatne_usluge)
        {
            this.Naziv = naziv;
            this.Kapacitet = kapacitet;
            this.NaseljenoMesto = naseljeno_mesto;
            this.Opis = opis;
            this.Slika = slika;
            this.Rezervacije = rezervacije;
            this.Zauzeto = zauzeto;
            this.Komentari = komentari;
            this.Agent = agent;
            this.TipSmestaja = tipSmestaja;
            this.KategorijaSmestaja = kategorijaSmestaja;
            this.Termini = termini;
            this.DodatneUsluge = dodatne_usluge;
        }

    }
}