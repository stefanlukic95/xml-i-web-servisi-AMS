using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;

namespace XML_Agent.Models
{
    public class Rezervacija
    {
        [BsonId]
        [BsonRepresentation(BsonType.ObjectId)]
        public string Id { get; set; }
        public DateTime DatumDolaska { get; set; }
        public DateTime DatumOdlaska { get; set; }
        public int Cena { get; set; }

        public Rezervacija(DateTime datumDolaska, DateTime datumOdlaska)
        {
            this.DatumDolaska = datumDolaska;
            this.DatumOdlaska = datumOdlaska;
          
        }

        
    }
}