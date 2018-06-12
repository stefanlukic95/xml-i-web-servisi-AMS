using MongoDB.Driver;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Web;
using XML_Agent.Repository;

namespace XML_Agent.Models
{
    public class DodatnaUslugaUnitOfWork
    {
        private MongoDatabase database;

        protected Repository<DodatnaUsluga> usluga;

        public DodatnaUslugaUnitOfWork()
        {
            var connectionString = ConfigurationManager.AppSettings["MongoDBHost"];
            var client = new MongoClient(connectionString);
            var server = client.GetServer();
            var databaseName = ConfigurationManager.AppSettings["MongoDBName"];
            database = server.GetDatabase(databaseName);
        }
        public Repository<DodatnaUsluga> Usluga
        {
            get
            {
                if (usluga == null)
                    usluga = new Repository<DodatnaUsluga>(database, "DodatnaUsluga");

                return usluga;
            }
        }
    }
}