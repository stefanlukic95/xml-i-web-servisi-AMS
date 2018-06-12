using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using XML_Agent.Models;

namespace XML_Agent.Services
{
    public class PorukaService
    {
        public PorukaUnitOfWork pUnitOfWork;

        public PorukaService()
        {
            pUnitOfWork = new PorukaUnitOfWork();
        }

        public void Delete(string id)
        {
            pUnitOfWork.Poruka.Delete(k => k.Id, id);
        }

        public Poruka Get(string id)
        {
            return pUnitOfWork.Poruka.Get(id);
        }

        public IQueryable<Poruka> GetAll()
        {
            return pUnitOfWork.Poruka.GetAll();
        }

        public void Insert(Poruka poruka)
        {
            pUnitOfWork.Poruka.Add(poruka);
        }

        public void Update(Poruka poruka)
        {
            pUnitOfWork.Poruka.Update(k => k.Id, poruka.Id, poruka);
        }
    }
}