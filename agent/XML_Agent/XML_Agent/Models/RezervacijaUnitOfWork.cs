using MongoDB.Driver;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Web;
using XML_Agent.Repository;

namespace XML_Agent.Models
{
    public class RezervacijaUnitOfWork
    {
        protected MongoDatabase database;
        protected Repository<Rezervacija> rezervacija;

        public RezervacijaUnitOfWork()
        {
            var connectionString = ConfigurationManager.AppSettings["MongoDBHost"];
            var client = new MongoClient(connectionString);
            var server = client.GetServer();
            var databaseName = ConfigurationManager.AppSettings["MongoDBName"];
            database = server.GetDatabase(databaseName);
        }

        public Repository<Rezervacija> Rezervacija
        {
            get
            {
                if (rezervacija == null)
                    rezervacija = new Repository<Rezervacija>(database, "Rezervacija");

                return rezervacija;
            }
        }


    }
}