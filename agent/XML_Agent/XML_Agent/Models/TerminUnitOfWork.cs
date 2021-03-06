﻿using MongoDB.Driver;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Web;
using XML_Agent.Repository;

namespace XML_Agent.Models
{
    public class TerminUnitOfWork
    {
        private MongoDatabase database;

        protected Repository<Termin> smestaj;

        public TerminUnitOfWork()
        {
            var connectionString = ConfigurationManager.AppSettings["MongoDBHost"];
            var client = new MongoClient(connectionString);
            var server = client.GetServer();
            var databaseName = ConfigurationManager.AppSettings["MongoDBName"];
            database = server.GetDatabase(databaseName);
        }
        public Repository<Termin> Termin
        {
            get
            {
                if (smestaj == null)
                    smestaj = new Repository<Termin>(database, "Termin");

                return smestaj;
            }
        }
    }
}