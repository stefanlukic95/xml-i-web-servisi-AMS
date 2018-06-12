using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using XML_Agent.Models;


namespace XML_Agent.IServices
{
    interface IDodatnaUslugaService
    {
        void Insert(DodatnaUsluga usluga);
        DodatnaUsluga Get(string id);
        IQueryable<DodatnaUsluga> GetAll();
        void Delete(string id);
        void Update(DodatnaUsluga usluga);
    }
}
