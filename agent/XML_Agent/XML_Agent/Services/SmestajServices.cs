using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using XML_Agent.Models;
using XML_Agent.IServices;


namespace XML_Agent.Services
{
    public class SmestajServices : ISmestajService
    {
        private readonly SmestajUnitOfWork sUnitOfwork;
        public SmestajServices()
        {
            sUnitOfwork = new SmestajUnitOfWork();
        }

        public void Delete(string id)
        {
            sUnitOfwork.Smestaj.Delete( s => s.Id, id);
        }

        public Smestaj Get(string id)
        {
            return sUnitOfwork.Smestaj.Get(id);
        }

        public IQueryable<Smestaj> GetAll()
        {
            return sUnitOfwork.Smestaj.GetAll();
        }

        public void Insert(Smestaj smestaj)
        {
            sUnitOfwork.Smestaj.Add(smestaj);
        }

        public void Update(Smestaj smestaj)
        {
            sUnitOfwork.Smestaj.Update(s => s.Id, smestaj.Id, smestaj);
        }
    }
}