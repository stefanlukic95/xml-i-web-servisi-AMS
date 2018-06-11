using MongoDB.Driver;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Web;
using XML_Agent.Repository;

namespace XML_Agent.Models
{
    public class PorukaUnitOfWork
    {
        private MongoDatabase database;

        protected Repository<Poruka> poruka;

        public PorukaUnitOfWork()
        {
            var connectionString = ConfigurationManager.AppSettings["MongoDBHost"];
            var client = new MongoClient(connectionString);
            var server = client.GetServer();
            var databaseName = ConfigurationManager.AppSettings["MongoDBName"];
            database = server.GetDatabase(databaseName);
        }
        public Repository<Poruka> Poruka
        {
            get
            {
                if (poruka == null)
                    poruka = new Repository<Poruka>(database, "Poruka");

                return poruka;
            }
        }
    }
}
