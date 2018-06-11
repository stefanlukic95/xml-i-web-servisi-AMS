using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using XML_Agent.IServices;
using XML_Agent.Models;

namespace XML_Agent.Services
{
    public class KomentariService : IkometariService
    {

        public KomentariUnitOfWork kUnitOfWork;

        public KomentariService()
        {
            kUnitOfWork = new KomentariUnitOfWork();
        }

        public void Delete(string id)
        {
            kUnitOfWork.Komentari.Delete( k => k.Id, id);
        }

        public Komentari Get(string id)
        {
            return kUnitOfWork.Komentari.Get(id);
        }

        public IQueryable<Komentari> GetAll()
        {
            return kUnitOfWork.Komentari.GetAll();
        }

        public void Insert(Komentari komentari)
        {
            kUnitOfWork.Komentari.Add(komentari);
        }

        public void Update(Komentari komentari)
        {
            kUnitOfWork.Komentari.Update(k => k.Id, komentari.Id, komentari);
        }
    }
}