using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;


namespace XML_Agent.Models
{
    public class Komentari
    {
        [BsonId]
        [BsonRepresentation(BsonType.ObjectId)]
        public string Id { get; set; }
        public string Sadrzaj { get; set; }

        [BsonIgnore]
        public bool Odobren { get; set; }
    }
}