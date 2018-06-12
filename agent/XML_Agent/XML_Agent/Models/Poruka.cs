using MongoDB.Bson.Serialization.Attributes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using MongoDB.Bson;

namespace XML_Agent.Models { 
    
    public class Poruka
    {
        [BsonId]
        [BsonRepresentation(BsonType.ObjectId)]
        public string Id { get; set; }
        public string Sadrzaj { get; set; }
        public string Posiljalac { get; set; }
        public string Primalac { get; set; }
    }
}