using MongoDB.Driver;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Web;
using XML_Agent.Repository;

namespace XML_Agent.Models
{
    public class KomentariUnitOfWork
    {
        private MongoDatabase database;

        protected Repository<Komentari> komentari;

        public KomentariUnitOfWork()
        {
            var connectionString = ConfigurationManager.AppSettings["MongoDBHost"];
            var client = new MongoClient(connectionString);
            var server = client.GetServer();
            var databaseName = ConfigurationManager.AppSettings["MongoDBName"];
            database = server.GetDatabase(databaseName);
        }
        public Repository<Komentari> Komentari
        {
            get
            {
                if (komentari == null)
                    komentari = new Repository<Komentari>(database, "Komentari");

                return komentari;
            }
        }
    }
}