using MongoDB.Driver;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Web;
using XML_Agent.Repository;

namespace XML_Agent.Models
{
    public class SmestajUnitOfWork
    {
        private MongoDatabase database;

        protected Repository<Smestaj> smestaj;

        public SmestajUnitOfWork()
        {
            var connectionString = ConfigurationManager.AppSettings["MongoDBHost"];
            var client = new MongoClient(connectionString);
            var server = client.GetServer();
            var databaseName = ConfigurationManager.AppSettings["MongoDBName"];
            database = server.GetDatabase(databaseName);
        }
        public Repository<Smestaj> Smestaj
        {
            get
            {
                if (smestaj == null)
                    smestaj = new Repository<Smestaj>(database, "Smestaj");

                return smestaj;
            }
        }
    }
}