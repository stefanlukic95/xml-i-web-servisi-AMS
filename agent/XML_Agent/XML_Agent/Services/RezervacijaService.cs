using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using XML_Agent.IServices;
using XML_Agent.Models;
using XML_Agent.Repository;

namespace XML_Agent.Services
{
    public class RezervacijaService : IRezervacijaService
    {

        public RezervacijaUnitOfWork rUnitOfWork;

        public RezervacijaService()
        {
            rUnitOfWork = new RezervacijaUnitOfWork();
        }
        public void Delete(string id)
        {
            rUnitOfWork.Rezervacija.Delete(d => d.Id, id);
        }

        public Rezervacija Get(string id)
        {
            return rUnitOfWork.Rezervacija.Get(id);
        }

        public IQueryable<Rezervacija> GetAll()
        {
            return rUnitOfWork.Rezervacija.GetAll();
        }

        public void Insert(Rezervacija rezervacija)
        {
            rUnitOfWork.Rezervacija.Add(rezervacija);
        }

        public void Update(Rezervacija rezervacija)
        {
            rUnitOfWork.Rezervacija.Update(d => d.Id, rezervacija.Id, rezervacija);
        }
    }
}