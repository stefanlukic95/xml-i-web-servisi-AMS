using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using XML_Agent.Models;

namespace XML_Agent.IServices
{
   public interface ISmestajService
    {
        void Insert(Smestaj smestaj);
        Smestaj Get(string id);
        IQueryable<Smestaj> GetAll();
        void Delete(string id);
        void Update(Smestaj smestaj);
    }
}
