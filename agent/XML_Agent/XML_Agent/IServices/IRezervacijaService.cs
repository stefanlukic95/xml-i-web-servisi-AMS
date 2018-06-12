using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using XML_Agent.Models;

namespace XML_Agent.IServices
{
    interface IRezervacijaService
    {
        void Insert(Rezervacija rezervacija);
        Rezervacija Get(string id);
        IQueryable<Rezervacija> GetAll();
        void Delete(string id);
        void Update(Rezervacija rezervacija);
    }
}
